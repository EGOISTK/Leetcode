package com.egoistk;

public class Solution {
//    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (target == nums[i] + nums[j]) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode p = l1, q = l2, l = new ListNode(0);
//        ListNode curr = l;
//        int x, y, sum, carry = 0;
//        while (p!= null || q!= null) {
//            x = (p != null)?p.val:0;
//            y = (q != null)?q.val:0;
//            sum = x + y + carry;
//            curr.next = new ListNode(sum%10);
//            carry = sum/10;
//            if (p != null) {
//                p = p.next;
//            }
//            if (q != null) {
//                q = q.next;
//            }
//            curr = curr.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return l.next;
//    }

//    public static int lengthOfLongestSubstring(String s) {
//        char c;
//        boolean flag = false;
//        int length = s.length(), currLength = 0;
//        if (length < 2) return length;
//        //滑动字符子串长度currLength
//        for (currLength = length; currLength > 1; currLength--) {
//            //滑动字符子串位置head
//            for (int head = 0; head <= length - currLength; head++) {
//                //滑动字符子串内遍历查询重复字符
//                for (int i = head; i < head + currLength - 1; i++) {
//                    c = s.charAt(i);
//                    for (int j = i + 1; j < head + currLength; j++) {
//                        //如果遍历中遇到重复字符，则跳出循环，字符子串右移一位
//                        if (c == s.charAt(j)) {
//                            flag = true;
//                            break;
//                        }
//                    }
//                    if (flag) {
//                        flag = false;
//                        break;
//                    }
//                    //如果遍历结束,字符子串内无重复字符，返回当前长度currLength
//                    if (i == head + currLength - 2) return currLength;
//                }
//            }
//
//        }
//        return currLength;
//    }

//    public static int lengthOfLongestSubstring(String s) {
//        char c;
//        boolean flag = false;
//        int head = 0, tail = 1, curr, length = s.length(), currLength = 0, maxLength = 0;
//        if (length < 2) return length;
//        //线性遍历整个字符串s，每次遇到重复字符，记录当前无重字符子串长度并与maxLength比较取大，字符子串头部head右移一位
//        for (; head < length - currLength; head++) {
//            for (; tail < length; tail++) {
//                c = s.charAt(tail);
//                for (curr = head; curr < tail; curr++) {
//                    if (c == s.charAt(curr)) {
//                        currLength = tail - head;
//                        maxLength = (maxLength > currLength)?maxLength:currLength;
//                        head = curr + 1; //head重定位
//                                     //tail不重新赋值，也会自加，相当于++tail
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag) {
//                    flag = false;
//                    continue;
//                }
//                if (tail == length - 1 && curr == tail) {
//                    currLength = tail - head + 1;
//                    return (maxLength > currLength)?maxLength:currLength;
//                }
//            }
//        }
//        return maxLength;
//    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length1 = nums1.length, length2 = nums2.length, length = length1 + length2;
//        int[] nums = new int[length1 + length2];
//        length1--;
//        length2--;
//        while (length1 >= 0 && length2 >= 0) {
//            nums[length1 + length2 + 1] = (nums1[length1] >= nums2[length2])?nums1[length1--]:nums2[length2--];
//        }
//        while (length1 >= 0) {
//            nums[length1] = nums1[length1--];
//        }
//        while (length2 >= 0) {
//            nums[length2] = nums2[length2--];
//        }
//        if (length%2 == 0) {
//            return (double) (nums[length/2 - 1] + nums[length/2])/2;
//        } else {
//            return (double) nums[length/2];
//        }
//    }

//    public static String longestPalindrome(String s) {
//        if (s.length() < 2) return s;
//        String longerPalindrome = "";
//        int length = s.length(), i, j, k;
//        for (i = 1; i < length; i++) {
//            if (s.charAt(i - 1)==s.charAt(i)) {
//                j = i - 1;
//                k = i;
//                while (j >= 0&&k < length) {
//                    if (s.charAt(j) == s.charAt(k)) {
//                        j--;
//                        k++;
//                    } else {
//                        break;
//                    }
//                }
//                if ((k - j - 1) > longerPalindrome.length()) {
//                    longerPalindrome = s.substring(j + 1, k);
//                }
//            }
//            if (i < length - 1&&s.charAt(i - 1)==s.charAt(i + 1)) {
//                j = i - 1;
//                k = i + 1;
//                while (j >= 0&&k < length) {
//                    if (s.charAt(j) == s.charAt(k)) {
//                        j--;
//                        k++;
//                    } else {
//                        break;
//                    }
//                }
//                if ((k - j - 1) > longerPalindrome.length()) {
//                    longerPalindrome = s.substring(j + 1, k);
//                }
//            }
//        }
//        return longerPalindrome;
//    }

//    public static String convert(String s, int numRows) {
//        if (numRows == 1) return s;
//        String ans = "";
//        int i, j, k = 0, map[][], numColumns, length = s.length();
//        numColumns = length < numRows? length : length / (2 * numRows - 2) * (numRows + 1)
//                + (length % (2 * numRows - 2) > numRows ? length % (2 * numRows - 2) % numRows + 1 : 1);
//        map = new int[numRows][numColumns];
//        for (i = 0; i < numRows; i++) {
//            for (j = 0; j < numColumns; j++) {
//                map[i][j] = -1;
//            }
//        }
//        i = j = 0;
//        while (k < length) {
//            while (i < numRows - 1 && k < length) {
//                map[i++][j] = k++;
//            }
//            while (i > 0 && j < numColumns && k < length) {
//                map[i--][j++] = k++;
//            }
//        }
//        for (i = 0; i < numRows; i++) {
//            for (j = 0; j < numColumns; j++) {
//                if (map[i][j] != -1) {
//                    ans += s.charAt(map[i][j]);
//                }
//            }
//        }
//        return ans;
//    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String ans = "";
        int i, j, length = s.length();
        for (i = 0; i < numRows; i++) {
            for (j = i; j < length; j += 2 * numRows -2) {
                ans += s.charAt(j);
                if (i != 0 && i != numRows - 1 && j + 2 * numRows - 2 * i - 2 < length) {
                    ans += s.charAt(j + 2 * numRows - 2 * i - 2);
                }
            }
        }
        return ans;
    }

}