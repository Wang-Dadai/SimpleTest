package TestPackage;

public class LeeCode {
	
	public static void main(String[] args) {
		
		int[] nums = new int[]{-2,1,4,3,5};
		
		int[] twonums = twoSum(nums, 7);
		for(Integer num : twonums){
			System.out.println(num);
		}
		System.out.println(maxProduct(new int[]{-2,1,4,3,5}));
		
	}

	public static int maxProduct(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        
        int global = nums[0];
        int max_local = nums[0];
        int min_local = nums[0];
        
        for(int i=1;i<nums.length;i++){
        	int tmp = max_local;
        	max_local = Math.max(max_local*nums[i], nums[i]*min_local);
        	max_local = Math.max(max_local, nums[i]);
        	min_local = Math.min(tmp*nums[i], nums[i]*tmp);
        	min_local = Math.min(min_local,nums[i]);
        	global = Math.max(max_local, global);
        }
        
        return global;
    }
	
	public static int[] twoSum(int[] nums, int target) {
		
		for(int i=0;i<nums.length;i++){
			
			if(nums[i]<=target){
				for(int j=0;j<nums.length;j++){
					if(nums[j]!=nums[i] && nums[j]<=target){
						if(nums[j]+nums[i]==target){
							return new int[]{nums[i],nums[j]};
						}
					}
				}
			}
		}
		return new int[]{};
	}
	
	
	 //Definition for singly-linked list.
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	      
		 ListNode result = new ListNode(0);
		 ListNode tmp = result;
		 
		 int factor = 0;
		 while(l1!=null || l2!=null){
			 if(l1!=null && l2!=null){
				 int tmpval = l1.val+ l2.val+factor;
				 tmp.val = tmpval%10;
				 factor = tmpval/10;
				 l1 = l1.next;
				 l2 = l2.next;
			 }else if(l1!=null){
				 int tmpval = l1.val + factor;
				 tmp.val = tmpval%10;
				 factor = tmpval/10;
				 l1 = l1.next;
			 }else if(l2!=null){
				 int tmpval = l2.val + factor;
				 tmp.val = tmpval%10;
				 factor = tmpval/10;
				 l2 = l2.next;
			 }
			 
			 if(l1!=null || l2!=null){
				 tmp.next = new ListNode(0);
				 tmp =tmp.next;
			 }
			 
		 }
		 if(factor>0){
			 tmp.next = new ListNode(factor);
			 
		 }
		 return result;
	 }
	
	 public int lengthOfLongestSubstring(String s) {
	        
	        int globalLength = 0;
	        int localLength = 0;
	        String localStr = "";
	        
	        for(int i=0;i<s.length();i++){
	        	
	        	int charIndex = localStr.indexOf(s.charAt(i)); 
	        	
	        	if(charIndex<0){
	        		localStr = localStr + s.charAt(i);
	        		localLength++;
	        	}else{
	        		localStr = localStr.substring(charIndex+1, localStr.length()) + s.charAt(i);
	        		localLength = localLength - charIndex;
	        	}
	        	if(localLength>globalLength){
	        		globalLength = localLength;
	        	}
	        }
	        return globalLength;
	        
	    }
	 
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
		 int m = nums1.length;
		 int n = nums2.length;
		 
		 int[] tmp = new int[m+n];
		 
		 int currentM = 0;
		 int currentN = 0;
		 int currentTmp = 0;
		 
		 while(currentM < m && currentN < n){
			 if(nums1[currentM]>nums2[currentN]){
				 tmp[currentTmp++] = nums2[currentN++];
			 }else{
				 tmp[currentTmp++] = nums1[currentM++];
			 }
		 }
		 while(currentM < m){
			 tmp[currentTmp++] = nums1[currentM++];
		 }
		 while(currentN < n){
			 tmp[currentTmp++] = nums2[currentN++];
		 }
		 
		 if((m+n)%2==0){
			 return (tmp[(m+n)/2-1]+tmp[(m+n)/2])/2.0;
		 }else{
			 return tmp[(m+n)/2];
		 }
		 
	 	}
	 
	 public String longestPalindrome(String s) {
	        
		 String max = "";
		 
		 if(s.length()<=0){
			 return null;
		 }
		 
		 for(int i=0;i<s.length();i++){
			 String tmp ="";
			 for(int j=0;j+i<s.length() && i-j>=0;j++){
				 if(s.charAt(i+j)==s.charAt(i-j)){
					 tmp = s.substring(i-j, i+j+1);
				 }else{break;}
			 }
			 if(tmp.length()>max.length()){
				 max = tmp;
			 }
			 for(int j=0;i-j>=0 && i+j+1<s.length();j++){
				 if(s.charAt(i-j)==s.charAt(i+j+1)){
					 tmp = s.substring(i-j,i+j+2);
				 }else{break;}
			 }
			 if(tmp.length()>max.length()){
				 max = tmp;
			 }
		 }
		 return max;
		 
	    }
	 
}
