package com.qa
package controllers

trait CrudController[A] {
  def readAll(): Seq[A]
  def create(): A
  def update(): A
  def delete(): Int
}
