class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        ns, nt = len(s), len(t)

        # ensure s is shorter than t
        if ns > nt:
            return self.isOneEditDistance(t,s)
        
        # strings are not one edit away from distance if diff(len) >1
        if nt-ns>1:
            return False
        
        for i in range(ns):
            if s[i] != t[i]:
                # strings have same len
                if ns == nt:
                    return s[i+1:] == t[i+1:]
                # if strings have different lengths
                else:
                    return s[i:] == t[i+1:]
        
        # if no diffs in ns distance
        # strings are one edit away
        return ns +1 == nt
        