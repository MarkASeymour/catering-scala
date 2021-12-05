package com.markseymour

object Main extends App {
  val reader: FileReader = new FileReader()
  var inventoryMap: Map[String, CateringItem] = reader.loadItems()

  for((id, item) <- inventoryMap) {
    var cateringItem: CateringItem = item
    println(id)
    println(cateringItem.getName)
  }
}
