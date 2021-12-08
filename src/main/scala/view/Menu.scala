package view

import catering._
import scala.io.StdIn.readLine

import java.text.DecimalFormat

class Menu (var inventory: Inventory, var cart: ShoppingCart, var handler: Handler){
  val format: DecimalFormat = new DecimalFormat("##.00")
  val conv: Convenience = new Convenience



  def mainMenu(): Boolean = {
    println("(1) Display Catering Items")
    println("(2) Order")
    println("(3) Quit")
    val response = readLine()
    handler.mainMenuChoices(response)

  }

  def orderMenu(): Unit = {
    var response: String = ""
    while(!(response == "3")) {
      println("(1) Add Money")
      println("(2) Select Products")
      println("(3) Complete Transaction")
      val response = readLine()
      // todo: handler order menu choices
    }
  }

  def printInventory(): Unit = {
    println(conv.toInvString("ID", "Item Name", "Price", "Type", "Stock"))
    println("----------------------------------------------------------")

    for((k,v) <- inventory.inventoryMap) {
      println(conv.toInvString(v.itemId, v.name, "$" + format.format(v.price), v.foodCat, v.quantity.toString))
    }

  }




}
