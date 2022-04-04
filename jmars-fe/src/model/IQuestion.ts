import {IQuestionType} from "./IQuestionType";

export interface IQuestion {
    id: number,
    value: string,
    type: IQuestionType,
    values?: string[]
}
