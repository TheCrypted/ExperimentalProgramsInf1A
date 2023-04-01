from timeit import default_timer as timer

start = timer()

board = [
    [1, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 7, 0, 1, 0, 0, 9, 6, 3],
    [0, 0, 0, 8, 6, 7, 0, 0, 0],
    [4, 0, 0, 0, 0, 0, 2, 9, 0],
    [5, 0, 2, 7, 0, 1, 8, 0, 6],
    [0, 9, 1, 0, 0, 0, 0, 0, 7],
    [0, 0, 0, 4, 5, 8, 0, 0, 0],
    [7, 4, 6, 0, 0, 9, 0, 2, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 4]
]

def print_board(board):
    for i in range(len(board)):
        if i%3 == 0 and i != 0:
            print('-------------------------------')
        for j in range(len(board[0])):
            if j%3 == 0 and j != 0:
                print(' | ', end='')

            if j == 8:
                print(board[i][j])
            else:
                print(str(board[i][j]) + ' ', end='')


def find_empty(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                return (i, j)
    return None


def solve(board):
    find = find_empty(board)
    if not(find):
        return True
    else:
        row, col = find

    for i in range(1,10):
        if valid(board, i, (row, col)):
            board[row][col] = i

            if solve(board):
                return True

            board[row][col] = 0
    return False

def valid(board, number, coord):
    # Row
    for i in range(len(board[0])):
        if board[coord[0]][i] == number and coord[1] != i:
            return False

    # Column
    for i in range(len(board)):
        if board[i][coord[1]] == number and coord[0] != i:
            return False

    # Box
    box_x = coord[1] // 3
    box_y = coord[0] // 3

    for i in range(box_y * 3, box_y * 3 + 3):
        for j in range(box_x * 3, box_x * 3 + 3):
            if board[i][j] == number and (i, j) != coord:
                return False

    return True

print_board(board)
print('_________________________')
solve(board)
print_board(board)

end = timer()
print('The time taken for the given computation is {} seconds.'.format(end - start))
