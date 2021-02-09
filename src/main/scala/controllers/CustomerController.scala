package com.qa
package controllers

import domain.Customer
import com.qa.dao.CustomerDAO
import com.qa.utils.Utils
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

class CustomerController(utils: Utils) extends CrudController {
  override def create(): Unit = {
    print("Please enter the first name of the customer: ")
    val firstName = utils.getString
    print("Please enter the surname of the customer: ")
    val surname = utils.getString

    val createFuture = CustomerDAO.create(Customer(0, firstName, surname))

    createFuture.onComplete {
      case Success(value) =>
        println(value)
      case Failure(error) =>
        error.printStackTrace()
    }

  }

  override def read(): Unit = {
    print("Please enter the ID of the customer: ")
    val cid = utils.getInt

    val readFuture = CustomerDAO.read(cid)

    readFuture.onComplete {
      case Success(value) =>
        print("\n")
        println(value.getOrElse("User Not Found"))
      case Failure(error) =>
        error.printStackTrace()
    }
  }

  override def readAll(): Unit = {
    val readAllFuture = CustomerDAO.readAll()

    readAllFuture.onComplete {
      case Success(value) =>
        print("\n")
        value foreach (println)
      case Failure(error) =>
        error.printStackTrace()
    }
  }

  override def update(): Unit = {
    readAll()

    print("Please enter the ID of the customer: ")
    val cid = utils.getInt
    print("Please enter the first name of the customer: ")
    val firstName = utils.getString
    print("Please enter the surname of the customer: ")
    val surname = utils.getString

    val updateFuture = CustomerDAO.update(Customer(cid, firstName, surname))

    updateFuture.onComplete {
      case Success(value) =>
        print("\n")
        println(value)
      case Failure(error) =>
        error.printStackTrace()
    }
  }

  override def delete(): Unit = {
    readAll()

    print("Please enter the ID of the customer: ")
    val cid = utils.getInt

    val deleteFuture = CustomerDAO.delete(cid)

    deleteFuture.onComplete{
      case Success(1) =>
        print("\n")
        println("Delete successful")
      case Success(0) =>
        print("\n")
        println("User Doesn't Exist")
      case Failure(error) =>
        error.printStackTrace()
    }

  }

}
