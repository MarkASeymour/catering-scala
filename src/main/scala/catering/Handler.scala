package catering

import view.Menu

import java.text.DecimalFormat
import scala.io.StdIn.readLine

class Handler (var inventory: Inventory,var shoppingCart: ShoppingCart, var menu: Menu = null){


  val format: DecimalFormat = new DecimalFormat("##.00")

  def setMenu(menu: Menu): Unit = {
    this.menu = menu
  }


  def mainMenuChoices(response: String): Boolean = {
    if (response == "1") {
      menu.printInventory()
      return true

    }else if (response == "2") {
      menu.orderMenu()
      return true

    } else if(response == "3") {
      println("Thanks for shopping with us! Have a great day!")
      return false

    }
    true

  }

  def orderMenuChoices(response: String): Boolean = {
    var returnToMenu = false
    if(response == "1") {
      println("Enter an amount to increase: ")
      var balanceIncrease: Double = readLine().toDouble
      if(!(balanceIncrease == balanceIncrease.toInt)) {
        println("You can only add whole dollar amounts, no change!")
        println("--------------------------------------------------")
      } else {
        if((shoppingCart.balance + balanceIncrease) > 5000) {
          println("You can only add up to 5000!")
          println("--------------------------------------------------")
        } else{
          shoppingCart.addToBalance(balanceIncrease)
          println("--------------------------------------------------")
        }
        returnToMenu = false
      }
    }
    else if(response == "2") {
      var currentStock = 0
      println("Enter product ID: ")
      val idResponse = readLine()
      val exists = inventory.itemExists(idResponse)
      if(!exists) {
        println("Please enter a valid ID")
        println("------------------------------------------")
      }
      else{
        println("Enter quantity: ")
        val quantityResponse: Int = readLine().toInt
        currentStock = inventory.inventoryMap(idResponse).quantity
        var totalPrice = shoppingCart.getTotalPrice(inventory, idResponse, quantityResponse)
        if((shoppingCart.balance - totalPrice) < 0) {
          println("Insufficient Funds. Add more to your balance to continue.")
          println("----------------------------------------------------------")
        } else {
          if(currentStock == 0){
            println("Item is SOLD OUT")
            println("----------------------------------------------------------")
          } else if (!(currentStock >= quantityResponse.toInt)) {
            println("Insufficient Stock. Please try a reduced quantity.")
            println("----------------------------------------------------")
          } else {
            shoppingCart.subtractFromBalance(totalPrice)
            inventory.inventoryMap(idResponse).quantity = currentStock - quantityResponse
            shoppingCart.addToCart(idResponse, quantityResponse)
            println("-----------------------------------------")
          }
          returnToMenu = false
        }

      }

    }
    else if (response == "3") {
      //todo: print final bill method
      printFinalBill()

      returnToMenu = true
    }
    returnToMenu
  }


  def printFinalBill(): Unit = {
    val menuFinalBill = shoppingCart.finalBill(inventory)
    for(billItem <- menuFinalBill) {
      println(billItem)
    }
    println("Total: $" + format.format(shoppingCart.getAmountOwed(inventory)))
    val owed = (shoppingCart.getAmountOwed(inventory)) - (shoppingCart.balance)
    println("Changed Owed: $" + format.format(shoppingCart.balance))
    println("----------------------------------------------------------")
    shoppingCart.subtractFromBalance(shoppingCart.balance)


  }

}
