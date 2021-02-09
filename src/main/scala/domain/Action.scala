package com.qa
package domain

object Action extends Enumeration {
  val CREATE = Value(0, "Create")
  val READ = Value(1, "Read")
  val READALL = Value(5, "Read All")
  val UPDATE = Value(2, "Update")
  val DELETE = Value(3, "Delete")
  val RETURN = Value(4, "Return")
}