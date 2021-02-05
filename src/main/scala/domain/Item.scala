package com.qa
package domain
import slick.jdbc.MySQLProfile.api._
case class Item(id: Int = 0, name: String, value: Int)

case class Items(tag:Tag) extends Table[Item](tag, "items"){
  def id = column[Int]("Item_ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("Name")
  def value = column[Int]("Value")
  def * = (id, name, value) <> (Item.tupled, Item.unapply)
}
