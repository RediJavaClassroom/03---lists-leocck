# [Class 03 - Data Structures - Lists](https://redi-school.github.io/intermediate-java/03-ds-1-lists/)

## Print Reversed List

Define a method called `printReversedList` that will print List of Integer reversed. 
```
Example:
With Input: [1, 3, 5, 2, 4]
It Prints: [4, 2, 5, 3, 1]
```

1. The method should be static, receive a List as parameter and return void
2. The method should work with Lists of any size

## Merge Two Lists

Define a method called `mergeLists` that will merge two Lists of Integers and return a new List as a result.
```
Example:
With Inputs: [2, 5, 9] and [1, 4, 0] 
It Returns: [2, 1, 5, 4, 9, 0]
```

1. The method should be static, receive two Lists as parameters and return a new List
2. The order of elements should follow the order inside the lists:
   1. The first element from the first list
   2. Then, the first element from the second list
   3. Next, the second element from the first list
   4. Then, the second element from the second list
   5. And so on...
3. The method should work with Lists of different sizes
4. The method should work with empty lists

## Find an Element

Define a method called `findFirstInList` that receives a List of Strings, and a String to search. The method should return the position (index) of the String, or, `-1` if the String is not found.

```
Example:
With Inputs: ["Apple", "Orange", "Grape", "Lemon", "Grape"], and "grape" 
It Returns: 2
```

1. The method should be static, receive a List of Strings and a String to search
2. The method should return an integer number, which represents the position (if found)
3. If the String is not found, the method should return -1
4. The method should work with Lists of any size, and should not differentiate upper and lower cased letters
5. In the same way, implement a method called `findLastInList`

## Second Smallest

Define a method called `secondSmallest` that returns the second-smallest number from a List of Integers

```
Examples:

With Input: [0, 1, 2, 3] 
It Returns: 1

With Input: [1, 3, 4, 1, 1, 4, 2] 
It Returns: 2

With Input: [2] 
It Returns: 2
```

1. The method should be static and receive a List of Integers
2. The method should return an Integer, which is the second-smallest number (if found)
3. If the List is empty, the method should return `null`