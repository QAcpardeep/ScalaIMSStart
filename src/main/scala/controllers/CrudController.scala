package com.qa
package controllers

trait CrudController {
  def create(): Unit

  def read(): Unit

  def readAll(): Unit

  def update(): Unit

  def delete(): Unit
}
