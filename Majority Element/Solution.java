/**
*思路：因为题目说了majority 必存在， 因为它的定义是数量至少是一半，那么若果排序的话，mid值一定就是我们要求的数
*=========
*上面的解法是O（nlogn）， 利用moore's voting alg可以达到O（n）
*/
/*
findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a)If a[maj_index] == a[i]
        count++
    (b)Else
        count--;
    (c)If count == 0
        maj_index = i;
        count = 1
3.  Return a[maj_index]

printMajority (a[], size)
1.  Find the candidate for majority
2.  If candidate is majority. i.e., appears more than n/2 times.
       Print the candidate
3.  Else
       Print "NONE"
*/

//moore解法我的理解是因为是假如某个值是majority candidate 那么假如之后的数不相等 我们就相当于缩小了array，
//如果仍然是那么我们就把count++
// = = 注意定义是more than ⌊ n/2 ⌋假如是【1，2，1，3】这就是没有 一定是大于⌊ n/2 ⌋！！
public class Solution {
    public int majorityElement(int[] num) {
        Arrays.sort(num);
        return num[num.length/2];
    }
}