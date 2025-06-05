nums = list(map(int, input().split()))
sorted_nums = sorted(nums)

if nums == sorted_nums:
    print("ascending")
elif nums == sorted(nums, reverse=True):
    print("descending")

else:
    print("mixed")