function twoSum(nums: number[], target: number): number[] {
    let res: number[];
    let visited= {}; // value required, index
    for (let i = 0; i < nums.length; i++) {
        const curr = nums[i];
        if(visited[curr] !== undefined){
            res=[visited[curr], i];
            return res;
        }
        else{
            visited[target-curr]=i;
        }
    }
    return res;
};