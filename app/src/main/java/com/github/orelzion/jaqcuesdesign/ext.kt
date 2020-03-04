package com.github.orelzion.jaqcuesdesign

fun <T> List<T>.copyOf(): MutableList<T> {
    return mutableListOf<T>().apply { addAll(this@copyOf) }
}

fun <E> Iterable<E>.replace(index: Int, elem: E) = mapIndexed { i, existing ->  if (i == index) elem else existing }