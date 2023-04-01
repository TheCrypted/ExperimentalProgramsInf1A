import pygame
from pygame.locals import *
import random
from OpenGL.GL import *
from OpenGL.GLU import *

pygame.init()
pygame.display.set_mode((900, 900), DOUBLEBUF | OPENGL)
pygame.display.set_caption("3d Graphics")

vertices = [
    (1, -1, -1),    (1, 1, -1),    (-1, 1, -1),    (-1, -1, -1),    (1, -1, 1),
    (1, 1, 1),    (-1, -1, 1),    (-1, 1, 1)]

edges = [
    (0, 1), (0, 3), (0, 4), (2, 1), (2, 3), (2, 7), (6, 3), (6, 4),
    (6, 7), (5, 1), (5, 4), (5, 7)]

colors = [
    (0.5, 0.0, 1.0), (1, 0, 0), (0, 1, 0), (1, 1, 0)]

surfaces = [
    (0, 1, 2, 3),    (3, 2, 7, 6),    (6, 7, 5, 4),    (4, 5, 1, 0),
    (1, 5, 7, 2),    (4, 0, 3, 6)]


def set_vertices(max_distance, min_distance = -20, camera_x = 0, camera_y = 0):
    camera_y = -1*int(camera_y)
    camera_x = -1*int(camera_x)

    x_value = random.randrange(camera_x-75, camera_x+75)
    y_value = random.randrange(camera_y-75, camera_y+75)
    z_value = random.randrange(-1 * max_distance, min_distance)
    new_vertices = []
    for vertex in vertices:
        new_vertex = []
        x = vertex[0] + x_value
        y = vertex[1] + y_value
        z = vertex[2] + z_value
        new_vertex.append(x)
        new_vertex.append(y)
        new_vertex.append(z)
        new_vertices.append(new_vertex)
    return new_vertices

def Cube(vertices):
    glBegin(GL_QUADS)
    for surface in surfaces:
        x = 0
        for vertex in surface:
            glColor3fv(colors[x])
            glVertex3fv(vertices[vertex])
            x += 1

    glEnd()

    glBegin(GL_LINES)
    for edge in edges:
        for vertex in edge:
            glVertex3fv(vertices[vertex])
    glEnd()


def main():
    time = pygame.time.Clock()
    # object_Passed = False

    max_distance = 100
    gluPerspective(45, 1, 0.1, max_distance)
    glTranslatef(0, 0, -40)
    x_move = 0
    y_move = 0

    cur_x = 0
    cur_y = 0

    UPFLAG = False
    DOWNFLAG = False
    LEFTFLAG = False
    RIGHTFLAG = False
    cube_dict = {}
    for x in range(70):
        cube_dict[x] = set_vertices(max_distance)

    while True:
        time.tick(60)
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
                pygame.display.quit()
                quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_a:
                    LEFTFLAG = True
                    x_move = 0.3
                elif event.key == pygame.K_d:
                    RIGHTFLAG = True
                    x_move = -0.3
                elif event.key == pygame.K_w:
                    UPFLAG = True
                    x_move = -0.3
                elif event.key == pygame.K_s:
                    DOWNFLAG = True
                    x_move = 0.3

            # elif event.type == pygame.MOUSEBUTTONDOWN:
            #     if event.button == 4:
            #         glTranslatef(0.0, 0.0, 0.05)
            #     elif event.button == 5:
            #         glTranslatef(0.0, 0.0, -0.05)

            elif event.type == pygame.KEYUP:
                if event.key == pygame.K_a:
                    LEFTFLAG = False
                    y_move = 0
                elif event.key == pygame.K_d:
                    RIGHTFLAG = False
                    y_move = 0
                elif event.key == pygame.K_w:
                    UPFLAG = False
                    x_move = 0
                elif event.key == pygame.K_s:
                    DOWNFLAG = False
                    x_move = 0

        if UPFLAG:
            glTranslatef(0.0, -0.3, 0)
        elif DOWNFLAG:
            glTranslatef(0.0, 0.3, 0)
        elif LEFTFLAG:
            glTranslatef(0.3, 0.0, 0)
        elif RIGHTFLAG:
            glTranslatef(-0.3, 0.0, 0)

        x = glGetDoublev(GL_MODELVIEW_MATRIX)
        camera_x = x[3][0]
        camera_y = x[3][1]
        camera_z = x[3][2]

        cur_x += x_move
        cur_y += y_move


        # if camera_z <= 0:
        #     object_Passed = True

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
        # glRotate(1, 2, 3, 2)
        glTranslatef(0, 0, 0.3)
        for cube in cube_dict:
            Cube(cube_dict[cube])

        for cube in cube_dict:
            if camera_z <= cube_dict[cube][0][2]:
                new_maximum = int(-1*(camera_z - (max_distance*2)))
                cube_dict[cube] = set_vertices(new_maximum, int(camera_z-max_distance),  cur_x, cur_y)

        pygame.display.flip()

# for x in range(10):
#     main()
#     glLoadIdentity()
main()
pygame.quit()