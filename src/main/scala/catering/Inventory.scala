package catering


class Inventory (var inventoryMap: Map[String, CateringItem]){



  def initialInventory(): Unit = {
    val reader: FileReader = new FileReader
    inventoryMap = reader.loadItems()
  }

  def itemExists(itemId: String): Boolean = {
    val exists = inventoryMap.contains(itemId)
    exists
  }

}
