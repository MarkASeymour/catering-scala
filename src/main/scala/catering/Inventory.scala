package catering


class Inventory (var inventoryMap: Map[String, CateringItem]){



  def initialInventory(): Unit = {
    val reader: FileReader = new FileReader
    inventoryMap = reader.loadItems()
  }

  def itemExists(itemId: String): Boolean = {
    var exists = false
    for((k,_) <- inventoryMap) {
      if(k == itemId) {
        exists = true
      }
    }
    exists
  }

}
