package com.qa
package dao

import domain.{Customer, Customers}
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import scala.concurrent.Future

object CustomerDAO extends DAO[Customer, Customers] {
  lazy val db: Database = Database.forConfig("mysqlDB")
  lazy val table: TableQuery[Customers] = TableQuery[Customers]

  override def create(obj: Customer): Future[String] = ???

  override def read(id: Int): Future[Option[Customer]] = ???

  override def readAll(): Future[Seq[Customer]] = ???

  override def update(obj: Customer): Future[String] = ???

  override def delete(id: Int): Future[Int] = ???
}
