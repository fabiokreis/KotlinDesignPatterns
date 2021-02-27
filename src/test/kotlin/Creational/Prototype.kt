package Creational

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

abstract class Shape: Cloneable {
    var id: String? = null
    var type: String? = null

    abstract fun draw()

    public override fun clone(): Any {
        var clone: Any? = null
        try {
            clone = super.clone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return clone!!
    }
}

class Rectangle: Shape() {
    override fun draw() {
        println("Inside Creational.Rectangle::draw() method.")
    }

    init {
        type = "Creational.Rectangle"
    }
}

class Square: Shape() {
    override fun draw() {
        println("Inside Creational.Square::draw() method.")
    }

    init {
        type = "Creational.Square"
    }
}

class Circle: Shape() {
    override fun draw() {
        println("Inside Creational.Circle::draw() method.")
    }

    init {
        type = "Creational.Circle"
    }
}

object ShapeCache {
    private val shapeMap = hashMapOf<String?, Shape>()

    fun loadCache() {
        val circle = Circle()
        val square = Square()
        val rectangle = Rectangle()

        shapeMap.put("1", circle)
        shapeMap.put("2", square)
        shapeMap.put("3", rectangle)
    }

    fun getShape(shapeId: String): Shape {
        val cachedShape = shapeMap.get(shapeId)
        return cachedShape?.clone() as Shape
    }
}

class PrototypeTest {
    @Test
    fun testPrototype() {
        ShapeCache.loadCache()
        val clonedShape1 = ShapeCache.getShape("1")
        val clonedShape2 = ShapeCache.getShape("2")
        val clonedShape3 = ShapeCache.getShape("3")

        clonedShape1.draw()
        clonedShape2.draw()
        clonedShape3.draw()

        Assertions.assertThat(clonedShape1.type).isEqualTo("Creational.Circle")
        Assertions.assertThat(clonedShape2.type).isEqualTo("Creational.Square")
        Assertions.assertThat(clonedShape3.type).isEqualTo("Creational.Rectangle")
    }
}