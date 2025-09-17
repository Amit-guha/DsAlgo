package com.example.problemsolving.leetcode

fun main() {
    println(canBeTypedWords("hello world", "ad"))
    println(canBeTypedWords("leet code", "lt"))
    println(canBeTypedWords("leet code", "e"))
    println(
        canBeTypedWords(
            "fwqcw ckhjxqcjvjbw dussctkmpskgqasrwbpwtjzexttchdzmmo luku f iqxwn kmeqdfqmhsbvbgovkhtnwvjowvubt vpjppr qdpqgptzahctjbtshrnpadzjwsd jsvarmcj tk ycrinnukpmitbyf zibgzucnzry bkut fjhzisl cjkjsflq r rj bdnxlbapdstu gx we yefcclthfyevrqvbqkkuulxxz fzcjxkyrlhysspipaauawtqgizr ree jmluyvhamihejf nsigdpjiyol iodrnia zoqyapwgxmewnhtctxxgwmklnnuxulfdhpmlsitsfyha ekugncc wwbryrvuqqkpavbzh io pdbrkoalvlmudcuuqedklhpagazlz qov bqhic koqp pmavmscyfcbn uwhxngjqjlbqlzesmgkqaveaotwgsx imfb wstbeuvhnucxztxe nranjcojhtwtxbotjxipdadjxd upnoqal fixxdv mghslrebxunxrstezjqufllbf fsr lxxrmvboxcvcqovlqjwlzjytbvrboe uzfij ypbhotdc xr xkuvuwgmtlzhbmxzguvramv wchs j gt fn bhpk jighg hethj xezuqtkx ybgig v fsnybqdfbnvinvoxqoeoyig uursrksjzblxpzlnysjcezkodxcaefopq xarkjoep juiixf sigqavkapcnqfe qupflkvxqev fqrkxhubspczlwsptijkziyvdu ezliezsamsmbx m kfkiogrpvjsgxxargznlfdgbofgvmgcttxbbhxhxyyzg nbubkuuvefkjousvbtqsj oimqxan x dxtkvtdyfc jposhqwgyfyjx qpmfnnbchbtmy fu cktnprvvaqkga jpfc iqnvu jp c nccx cpithedtx dzo",
            "nbgtkcusjforxeyvqilad"
        )
    )
}

fun canBeTypedWords(text: String, brokenLetters: String): Int {
    val hashMap = HashMap<Char, Int>()
    brokenLetters.forEach { 
       hashMap[it] = hashMap[it]?.plus(1) ?: 1
    }
    

    var count = 0
    val listOfString = text.split(" ")
    
    listOfString.forEach { word ->
        var canType = true
        word.forEach { ch ->
            if (hashMap.containsKey(ch)) {
                canType = false
                return@forEach
            }
        }
        if (canType) {
            count++
        }
    }

    return count
}