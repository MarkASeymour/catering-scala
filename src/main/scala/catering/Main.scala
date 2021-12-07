package catering

object Main extends App {
  val reader: FileReader = new FileReader()
  var inventoryMap: Map[String, CateringItem] = reader.loadItems()

  for((id, item) <- inventoryMap) {
    println(id)
    println(item.getName)
  }
}
