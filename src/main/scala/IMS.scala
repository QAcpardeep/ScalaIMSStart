package com.qa

import controllers.CrudController
import domain.Action._
import domain.{Action, Domain}
import domain.Domain._
import utils.Utils

class IMS(utils: Utils) {

  def imsStart(): Unit = {
    //Getting DB details
    println("What is your username")
    val username = utils.getString
    println("What is your password")
    val password = utils.getString

    //Getting User input fro which table they want to interact with
    println("Which entity would you like to use?")
    Domain.values foreach (value => println(s"$value?"))
    val domainChoice = domain()


    domainChoice match {
      case CUSTOMER =>
        val active = null
        getAction(domainChoice, active)
      case ITEM =>
        val active = null
        getAction(domainChoice, active)
      case ORDER =>
        val active = null
        getAction(domainChoice, active)
      case STOP =>
        ()
    }
  }

  def getAction(domain: Domain.Value, active: CrudController[Any]): Unit = {
    println(s"What would you like to do with $domain?")
    Action.values foreach (value => println(s"$value?"))
    print("Please type the action: ")
    val actionChoice = action()
    actionChoice match {
      case CREATE =>
        active.create()
        getAction(domain, active)
      case READ =>
        active.readAll()
        getAction(domain, active)
      case UPDATE =>
        active.update()
        getAction(domain, active)
      case DELETE =>
        active.delete()
        getAction(domain, active)
      case RETURN =>
        imsStart()
      case _ =>
        println("Invalid Response")
        getAction(domain, active)
    }
  }

  //this function gets the domain values, calls the utils to get user input and then checks if the user has entered matching values, then the enum is returned. If nothing matches then an error is returned.
  def domain(): Domain.Value = {
    val pick: String = utils.getString().toUpperCase()
    pick match {
      case "CUSTOMER" =>
        CUSTOMER
      case "ITEM" =>
        ITEM
      case "ORDER" =>
        ORDER
      case "STOP" =>
        STOP
      case _ =>
        println("Invalid Response")
        domain()
    }
  }

  //This function will take in action class values, take in a user input and then compare if the user input matches one of the values. Then it returns the enum.
  def action(): Action.Value = {
    val pick: String = utils.getString().toUpperCase()
    pick match {
      case "CREATE" =>
        CREATE
      case "READ" =>
        READ
      case "UPDATE" =>
        UPDATE
      case "DELETE" =>
        DELETE
      case "RETURN" =>
        RETURN
      case _ =>
        println("Invalid Response")
        action()
    }
  }
}
