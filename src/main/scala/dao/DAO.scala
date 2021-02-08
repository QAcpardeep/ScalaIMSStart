package com.qa
package dao

import scala.concurrent.Future

trait DAO[X, Y] {
  def create(obj: X): Future[String]
  def read(id: Int): Future[Option[X]]
  def readAll(): Future[Seq[X]]
  def update(obj: X): Future[String]
  def delete(id: Int): Future[Int]
}
