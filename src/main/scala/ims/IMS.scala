package com.qa
package ims

import scala.util.control.TailCalls._
import com.qa.controllers.CrudController
import com.qa.domain.Domain
import com.qa.domain.Action
import com.qa.domain.Domain._
import com.qa.domain.Action._

import com.qa.utils.Utils

class IMS(utils: Utils) {

  def imsStart(): () = {
    println("Which entity would you like to use?")
    Domain.values foreach(value => println(s"$value?")); print("Please type the name of the table: ")
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

  def getAction(domain: Domain.Value, active: CrudController[Any]): () = {
    println(s"What would you like to do with $domain?")
    Action.values foreach(value => println(s"$value?")); print("Please type the action: ")
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

  def domain(): Domain.Value = {
    val choice: String = utils.getString().toUpperCase()
    choice match {
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

  def action(): Action.Value = {
    val choice: String = utils.getString().toUpperCase()
    choice match {
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
