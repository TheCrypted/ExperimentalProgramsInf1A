import pyautogui as pg

distance = 200
pg.PAUSE = 2.5
while distance > 0:
        pg.drag(distance, 0, duration=0.5)   # move right
        distance -= 5
        pg.drag(0, distance, duration=0.5)   # move down
        pg.drag(-distance, 0, duration=0.5)  # move left
        distance -= 5
        pg.drag(0, -distance, duration=0.5)  # move up
