function twoSum(nums: number[], target: number): number[] {
    let res: number[] = [];
    let visited= new Map<number, number>(); // value required, index
    for (let i = 0; i < nums.length; i++) {
        const curr = nums[i];
        
        if(visited.has(curr)){
            res[0] = visited.get(curr);
            res[1] = i;
            return res;
        }
        else{
            visited.set(target-curr,i);
        }
    }

    return res;
};