package catering

import view.Menu

object Main extends App {
  val reader: FileReader = new FileReader()
  var inventory: Inventory = new Inventory(reader.loadItems())
  var cart: ShoppingCart = new ShoppingCart()
  var handler: Handler = new Handler(inventory, cart)
  val menu: Menu = new Menu(inventory, cart, handler)
  handler.setMenu(menu)
  var conitnueMenu = true
  while(conitnueMenu == true) {
    conitnueMenu = menu.mainMenu()
  }


}
