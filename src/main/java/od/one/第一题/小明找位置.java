package od.one.第一题;

import java.util.Scanner;

public class 小明找位置 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(5/2);
        int count = searchInsert(new int[]{93,95,97,100,102,123,155},110);
        System.out.println(count);
//        String sb = scanner.nextLine();
//        String mingNumber = scanner.nextLine();
//        String[] strings = sb.split(" ");

    }

    public static int searchInsert(int[] nums, int target) {
        int centerNum = nums.length/2;
        int fastCenterNum = 0;
        if (nums[0]>=target) {
            return 0;
        }
        if (nums[nums.length-1]<target) {
            return nums.length;
        }
        while (true) {
            if (nums.length % 2 == 0) {
                if (nums[centerNum] >=target && nums[centerNum-1]<target) {
                    return centerNum;
                }else if (nums[centerNum] <target){
                    int addNum = fastCenterNum>centerNum?(fastCenterNum-centerNum)/2:(centerNum-fastCenterNum)/2;
                    fastCenterNum = centerNum;
                    centerNum = centerNum + (addNum==0?1:addNum);
                } else {
                    int subNum = fastCenterNum>centerNum?(fastCenterNum-centerNum)/2:(centerNum-fastCenterNum)/2;
                    fastCenterNum = centerNum;
                    centerNum = centerNum - (subNum==0?1:subNum);
                }
            } else {
                if (nums[centerNum] > target) {
                    if (nums[centerNum-1]<target) {
                        return centerNum;
                    }
                    int subNum = fastCenterNum>centerNum?(fastCenterNum-centerNum)/2:(centerNum-fastCenterNum)/2;
                    centerNum = centerNum - (subNum==0?1:subNum);
                } else if(nums[centerNum] < target) {
                    if (nums[centerNum+1] >= target) {
                        return centerNum+1;
                    }
                    int addNum = fastCenterNum>centerNum?(fastCenterNum-centerNum)/2:(centerNum-fastCenterNum)/2;
                    fastCenterNum = centerNum;
                    centerNum = centerNum +  (addNum==0?1:addNum);
                } else {
                    if(nums[centerNum-1]<target) {
                        return centerNum;
                    }
                    int subNum = fastCenterNum>centerNum?(fastCenterNum-centerNum)/2:(centerNum-fastCenterNum)/2;
                    fastCenterNum = centerNum;
                    centerNum = centerNum - (subNum==0?1:subNum);
                }
            }
        }
    }

    public int searchInsertOne(int[] nums, int target) {
        int n = nums.length;

        // 定义target在左闭右闭的区间，[low, high]
        int low = 0;
        int high = n - 1;

        while (low <= high) { // 当low==high，区间[low, high]依然有效
            int mid = low + (high - low) / 2; // 防止溢出
            if (nums[mid] > target) {
                high = mid - 1; // target 在左区间，所以[low, mid - 1]
            } else if (nums[mid] < target) {
                low = mid + 1; // target 在右区间，所以[mid + 1, high]
            } else {
                // 1. 目标值等于数组中某一个元素  return mid;
                return mid;
            }
        }
        // 2.目标值在数组所有元素之前 3.目标值插入数组中 4.目标值在数组所有元素之后 return right + 1;
        return high + 1;
    }

}
