function removeDuplicates(nums: number[]): number {
    let k:number = 1;
    for(let i = 1; i<nums.length; i++){
        if(nums[k-1] !== nums[i] ){
            nums[k] = nums[i];
            k+=1;
        }
        else{
            continue;
        }
    }

    return k;
};