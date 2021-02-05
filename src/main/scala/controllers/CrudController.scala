package com.qa
package controllers

trait CrudController[A] {
  def readAll(): Unit
  def create(): Unit
  def update(): Unit
  def delete(): Unit
}
