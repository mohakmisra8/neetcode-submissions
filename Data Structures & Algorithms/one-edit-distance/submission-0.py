class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        ns = len(s)
        nt = len(t)

        if ns > nt:
            return self.isOneEditDistance(t,s)
        
        #strings are not one edit away from distance
        # if len is more than 1
        if nt -ns >1:
            return False
        
        for i in range(ns):
            if s[i] != t[i]:

                # if strings have same length
                if ns == nt:
                    return s[i+1:] == t[i+1:]
                else:
                    # different lengths
                    return s[i:] == t[i+1:]
        
        #no diffs in ns distance the strings are one edit away if t has one more char
        return ns +1 == nt
