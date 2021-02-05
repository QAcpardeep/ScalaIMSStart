package com.qa
package dao

import scala.concurrent.Future

trait DOA[T] {
  def create(obj: T): Future[T]
  def read(id: Int): Future[T]
  def readAll(): Future[List[T]]
  def update(obj: T): Future[T]
  def delete(id: Int): Future[Int]
}
