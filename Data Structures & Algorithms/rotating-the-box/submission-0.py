class Solution:
    def rotateTheBox(self, boxGrid: List[List[str]]) -> List[List[str]]:
        rows = len(boxGrid)
        cols = len(boxGrid[0])

        for r in range(rows-1,-1,-1):
            for c in range(cols-1,-1,-1):
                if boxGrid[r][c] == '#':
                    c2 = c+1
                    while c2 < cols and boxGrid[r][c2] == '.':
                        c2 += 1
                    
                    boxGrid[r][c] = '.'
                    boxGrid[r][c2-1] = '#'
        
        res = []
        for c in range(cols):
            col = []
            for r in range(rows -1,-1,-1):
                col.append(boxGrid[r][c])
            res.append(col)
        return res
        