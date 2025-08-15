package com.example.problemsolving.leetcode

import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.math.max

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println(totalFruits3(intArrayOf(0, 1, 2, 2)))
   // println(totalResult2(intArrayOf(1, 2, 1)))
  //  println(totalResult2(intArrayOf(1, 2, 3, 2, 2)))
  //  println(totalResult2(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)))
  //  println(totalResult2(intArrayOf(0,1,6,6,4,4,6)))
}

//1,2,3,2,2
//[0,1,2,2]
fun totalFruit(fruits: IntArray): Int {
    val hashSet = HashSet<Int>()
    var sum = 0
    var maxSum = 0
    var leftIndex = 0
    for (i in 0 until fruits.size) {
        if (!hashSet.contains(fruits[i])) {
            if (hashSet.size < 2) {
                hashSet.add(fruits[i])
                sum++
            } else {
                hashSet.remove(fruits[leftIndex])
                hashSet.add(fruits[i])
                maxSum = max(maxSum, sum)
                sum = 2
                leftIndex = i - 1
            }
        } else {
            sum++
        }
    }

    maxSum = max(maxSum, sum)
    return maxSum
}

fun totalResult2(fruits: IntArray): Int {
    val hashSet = HashSet<Int>()
    var sum = 0
    var maxSum = 0

    for (i in 0 until fruits.size) {
        hashSet.add(fruits[i])
        sum ++
        for (j in i + 1 until fruits.size) {
            println(j)
            if (hashSet.contains(fruits[j])) {
                sum++
            } else {
                if (hashSet.size < 2) {
                    hashSet.add(fruits[j])
                    sum ++
                }else{
                    maxSum = max(maxSum, sum)
                    sum = 0
                    hashSet.clear()
                    break
                }
            }
        }
        maxSum = max(maxSum, sum)
        sum = 0
        hashSet.clear()
    }

    maxSum = max(maxSum, sum)
    return maxSum
}

/*  if (hashSet.size < 2) {
          if (hashSet.contains(fruits[i])) {
              sum++
          } else {
              hashSet.add(fruits[i])
              sum++
          }
      } else {
          if (hashSet.contains(fruits[i])){
              sum ++
          }else{
              hashSet.add(fruits[i])
              hashSet.remove(fruits[left])
              maxSum = max(maxSum, sum)
              left++
          }
      }*/


//0,1,6,6,4,4,6
@RequiresApi(Build.VERSION_CODES.N)
fun totalFruits3(fruits : IntArray) : Int{
    val map = mutableMapOf<Int, Int>()
    var maxSum = 0
    var left = 0

    for(right in fruits.indices){
        map[fruits[right]] = map.getOrDefault(fruits[right],0) + 1

        while (map.size >2){
            map[fruits[left]] = map[fruits[left]]!! -1
            if (map[fruits[left]] == 0) {
                map.remove(fruits[left])
            }
            left ++
        }

        maxSum = max(maxSum, right - left + 1)
    }

    return maxSum
}