package com.qa

import utils.Utils

object Runner {
  def main(args: Array[String]): Unit = {
    val utils = new Utils()
    val ims = new IMS(utils)
    ims.imsStart()
    println("Goodbye!")
  }
}
