package com.qa
package domain

object Domain extends Enumeration {
  val CUSTOMER = Value(0, "Customer")
  val ITEM = Value(1, "Item")
  val ORDER = Value(2, "Order")
  val STOP = Value(3, "Stop")
}
