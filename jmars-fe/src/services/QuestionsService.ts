import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/dist/query/react";
import {IQuestion} from "../model/IQuestion";

export const questionsAPI = createApi({
    reducerPath: 'questionsAPI',
    baseQuery: fetchBaseQuery({baseUrl: 'http://localhost:5000/'}),
    tagTypes: ['Question'],
    endpoints: (build) => ({
        fetchAllQuestions: build.query<IQuestion[], void>({
            query: () => ({
                url: '/questions'
            }),
            providesTags: result => ['Question']
        }),
        // createPost: build.mutation<IQuestion, IQuestion>({
        //     query: (post) => ({
        //         url: '/posts',
        //         method: 'POST',
        //         body: post
        //     }),
        //     invalidatesTags: ['Post']
        // }),
        // updatePost: build.mutation<IQuestion, IQuestion>({
        //     query: (post) => ({
        //         url: `/posts/${post.id}`,
        //         method: 'PUT',
        //         body: post
        //     }),
        //     invalidatesTags: ['Post']
        // }),
        // deletePost: build.mutation<IQuestion, IQuestion>({
        //     query: (post) => ({
        //         url: `/posts/${post.id}`,
        //         method: 'DELETE'
        //     }),
        //     invalidatesTags: ['Post']
        // })
    })
})