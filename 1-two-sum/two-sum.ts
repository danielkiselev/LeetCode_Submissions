function twoSum(nums: number[], target: number): number[] {
    const visited= {};
    for (let i = 0; i < nums.length; i++) {
        const curr = nums[i];
        if(visited[curr] !== undefined){
            return [visited[curr], i];
        }
        else{
            visited[target-curr]=i;
        }
    }
    return [];
};