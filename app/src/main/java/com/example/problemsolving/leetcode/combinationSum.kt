package com.example.problemsolving.leetcode

class combinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val listOfInt = arrayListOf<Int>()
        val outPutList = mutableListOf<MutableList<Int>>()

        val targetVariable: Int = target
        for (i in candidates.indices) {
            var temp: Int = targetVariable
            if (temp.equals(candidates[i])) {
                outPutList.add(listOf<Int>(candidates[i]).toMutableList())
                // println(outPutList)
            } else {
                temp -= candidates[i]  //7-2 = 5 //7-3 =4
                // println("temp first $temp") //5
                // println("candidates ${candidates[i]}") //2
                if (temp > 0 /*&& temp > candidates[0]*/) {
                    listOfInt.clear()
                    listOfInt.add(candidates[i])
                    for (j in candidates.indices) {
                        // println("candidates in loop ${candidates[j]}")//2
                        // if (temp > 0) {//5
                        if (i == 0) {
                            for (k in 0 until 1) {
                                if (temp.equals(candidates[k])) { //2
                                    temp -= candidates[k]
                                    // println("temp Second loop $temp")
                                    listOfInt.add(candidates[k])
                                }
                                // }
                            }

                        } else {
                            for (k in i downTo (i - 1)) {
                                //println("candiates down to ${candidates[k]}")
                                if (temp.equals(candidates[k])) { //2
                                    temp -= candidates[k]
                                    //println("temp Second loop $temp")
                                    listOfInt.add(candidates[k])
                                }
                                // }
                            }
                        }

                        if ((temp > 0) && (temp > candidates[j])) {
                            temp = temp - candidates[0] //5-2 = 3  4-2 =2
                            //  println("temp third loop $temp")
                            listOfInt.add(candidates[0])
                        }
                    }

                    var totalSum = 0
                    for (sum in listOfInt.indices) {
                        totalSum = totalSum + listOfInt[sum]
                        if (totalSum == targetVariable) {
                            outPutList.add(listOfInt.sorted().toMutableList())
                           // println("second loop" + outPutList)
                        }
                    }
                    //outPutList.add(listOfInt.sorted().toMutableList())
                    // println("second loop" + outPutList)
                }

            }
        }
        for (k in 0 until outPutList.size - 1) {
            for (i in k + 1 until outPutList.size - 1) {
                if (outPutList[k] == outPutList[i]) {
                    // println("list $k ${outPutList[k]}")
                    //println("list $i ${outPutList[i]}")
                    outPutList.removeAt(i)
                }

            }
        }

        return outPutList
    }

}

fun main() {
  /*  val candidates: IntArray = intArrayOf(1,2)
    val targetVariable: Int = 3
    val combinationSum = combinationSum()
    println(combinationSum.combinationSum(candidates, targetVariable))*/

/*    var humidityLevel = 80
    var humidity = "humid"
    while (humidity == "humid"){
        humidityLevel-=5
        println("humidity decreased")

        if (humidityLevel<60){
            println("it's comfy now")
            humidity = "comfy"
        }
    }*/

    val cons = primaryCons("Amit",24)
    println("${cons.name} ${cons.age}")
    println(cons.message)

    val cons2 = primaryCons("B",20,"All")
    println("${cons2.name} ${cons2.age} ${cons2.property}")

}

class primaryCons(var name : String, var age : Int){
    var message : String
    var property : String = "all"
    init {
        this.message = "Hi $name"
    }

    constructor(name: String,age: Int, property : String) : this(name,age){
        this.property = property
        println("Secondary Constructor")
    }

}
