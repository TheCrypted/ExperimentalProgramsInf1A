import math
import pygame

pygame.init()

screen = pygame.display.set_mode((900, 900))
pygame.display.set_caption("CollisionSimulation")

WHITE = (255, 255, 255)
YELLOW = (255, 255, 0)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
RED = (255, 0, 0)
LIGHTBROWN = (181, 101, 29)
BROWN = (80, 78, 21)


class Ball():
    g = 0.981

    def __init__(self, x, y, radius, color, mass, vx, vy):
        self.x = x
        self.y = y
        self.radius = radius
        self.color = color
        self.velX = vx
        self.velY = vy
        self.accX = 0
        self.accY = 0
        self.mass = mass

    def draw(self, screen):
        pygame.draw.circle(screen, self.color, (self.x, self.y), self.radius)
        border = [(25, 25), (25, 875), (875, 875), (875, 25), (25, 25)]
        pygame.draw.lines(screen, BLUE, False, border, 2)

    def update(self, others):
        if (self.x <= 25 + self.radius and self.y <= 25 + self.radius) or \
                (self.x <= 25 + self.radius and self.y >= 875 - self.radius) or \
                (self.x >= 875 - self.radius and self.y <= 25 + self.radius) or \
                (self.x >= 875 - self.radius and self.y >= 875 - self.radius):
            self.velX = -self.velX
            self.velY = -self.velY
            self.accX = -self.accX
            self.accY = -self.accY
        elif self.x <= 25 + self.radius or self.x >= 875 - self.radius:
            self.velX = -self.velX
            self.accX = -self.accX
        elif self.y <= 25 + self.radius or self.y >= 875 - self.radius:
            self.velY = -self.velY
            self.accY = -self.accY

        for ball in others:
            if ball.color != self.color:
                v1x = self.collisionupdate(ball)[0]
                v1y = self.collisionupdate(ball)[1]

                self.velX += v1x
                self.velY += v1y

        self.x += self.velX
        self.y += self.velY

        self.velX += self.accX
        self.velY += self.accY

    def collisionupdate(self, other):
        other_x, other_y = other.x, other.y
        other_velX, other_velY = other.velX, other.velY
        distance_x = other_x - self.x
        distance_y = other_y - self.y
        distance = math.sqrt(distance_x ** 2 + distance_y ** 2)
        if distance <= self.radius + other.radius:
            firstOtherTermX = 2 * self.mass * self.velX / (self.mass + other.mass)
            secondOtherTermX = (self.mass - other.mass) * other_velX / (self.mass + other.mass)
            finalOtherVX = firstOtherTermX - secondOtherTermX

            firstOtherTermY = 2 * self.mass * self.velY / (self.mass + other.mass)
            secondOtherTermY = (self.mass - other.mass) * other_velY / (self.mass + other.mass)
            finalOtherVY = firstOtherTermY - secondOtherTermY

            firstTermX = 2 * other.mass * other_velX / (self.mass + other.mass)
            secondTermX = (self.mass - other.mass) * self.velX / (self.mass + other.mass)
            finalVX = firstTermX + secondTermX

            firstTermY = 2 * other.mass * other_velY / (self.mass + other.mass)
            secondTermY = (self.mass - other.mass) * self.velY / (self.mass + other.mass)
            finalVY = firstTermY + secondTermY

            return [finalVX, finalVY, finalOtherVX, finalOtherVY]


def main():
    run = True
    clock = pygame.time.Clock()

    white = Ball(79, 70, 28, WHITE, 14, 9, 4)
    red = Ball(180, 200, 40, RED, 20, 5, 8)
    balls = [white, red]

    while run:
        clock.tick(60)
        screen.fill((0, 0, 0))
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False

        for ball in balls:
            ball.update(balls)
            ball.draw(screen)
        pygame.display.update()

    pygame.quit()


main()


