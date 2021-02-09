package com.qa
package dao

import domain.{Customer, Customers}
import slick.jdbc.MySQLProfile.backend.Database
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object CustomerDAO extends DAO[Customer, Customers] {
  lazy val db: Database = Database.forConfig("mysqlDB")
  lazy val table: TableQuery[Customers] = TableQuery[Customers]
  val initUsersCmd = DBIO.seq(table.schema.create)
  db.run(initUsersCmd)

  override def create(obj: Customer): Future[String] = {
    db.run(table += obj).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  override def read(id: Int): Future[Option[Customer]] = {
    db.run(table.filter(_.id === id).result.headOption)
  }

  override def readAll(): Future[Seq[Customer]] = {
    db.run(table.result)
  }

  override def update(obj: Customer): Future[String] = {
    db.run(table.insertOrUpdate(obj)).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  override def delete(id: Int): Future[Int] = {
    db.run(table.filter(_.id === id).delete)
  }
}
