class Solution:
    def isPalindrome(self, s: str) -> bool:
        # we will solve this using two pointer approach 
        # here na we have to ignore everything that i not alpha numeric
        # and also that we have to na here, make sure ki lower mei hi compare kare

        left = 0
        right = len(s) - 1

        while left < right:
            # idhar left = right ki zarurat nahi h kyuki wo ek alphabet ko nahi karga to bhi chalega 
            # first lets check for it ki agar left mei apha numeric nahi h to skip means left +
            #  use while loop kyuki agar punctuation back to back ho to
            while left < right and not (s[left].isascii() and  s[left].isalnum()):
                left += 1
            
            # now same check for right one
            while left < right and not (s[right].isascii() and  s[right].isalnum()):
                right -= 1
            
            else:
                if s[left].lower() != s[right].lower():
                    return False

                else:
                    left += 1
                    right -= 1


        return True