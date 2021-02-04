package com.qa

import utils.Utils

import com.qa.ims.IMS

object Runner {
  def main(args: Array[String]): Unit = {
    val utils = new Utils()
    val ims = new IMS(utils)
    ims.imsStart()
    println("Goodbye!")
  }
}
