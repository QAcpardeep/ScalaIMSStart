package com.qa
package domain
import slick.jdbc.MySQLProfile.api._
case class Customer(id: Int = 0, firstName: String, surname: String)

case class Customers(tag: Tag) extends Table[Customer](tag, "customers"){
  def id = column[Int]("Customer_ID", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("First_Name")
  def surname = column[String]("Surname")
  def * = (id, firstName, surname) <> (Customer.tupled, Customer.unapply)
}