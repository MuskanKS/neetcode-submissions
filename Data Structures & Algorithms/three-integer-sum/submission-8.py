class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue

            if nums[i] > 0:
                break

            # kyuki bhai abhi jo bhi hoga wo nums[i] se bada hi bhoga kyuki sorted hai

            left = i + 1
            right = len(nums) - 1

            while left < right:
                # kyuki same element ko thodi na add karna h so they cant be equal 
                sum = nums[i] + nums[left] + nums[right]
                if sum > 0:
                    right -= 1
                elif sum < 0:
                    left += 1
                else:
                    res.append((nums[i], nums[left], nums[right]))
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1

        return res