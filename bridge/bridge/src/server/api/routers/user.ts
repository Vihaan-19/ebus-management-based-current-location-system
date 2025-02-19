import { date, z } from "zod";
import { createTRPCRouter, publicProcedure } from "@/server/api/trpc";
import { db } from "@/server/db";
export const userRouter = createTRPCRouter({
  addUser: publicProcedure
    .input(
      z.object({
        name: z.string(),
        email: z.string().email(),
        role: z.enum(["CREATOR", "EDITOR"]),
      }),
    )
    .mutation(async ({ ctx, input }) => {
      const newuser = await ctx.db.user.create({
        data: {
          name: input.name,
          email: input.email,
          role: input.role,
        }
      });

      return newuser;
    })
});
