import React from 'react';
import {
    Checkbox,
    Container,
    FormControl,
    FormControlLabel,
    InputLabel,
    MenuItem,
    Select,
    Stack,
    TextField,
    Typography
} from "@mui/material";
import {questionsAPI} from "../services/QuestionsService";
import {IQuestionType} from "../model/IQuestionType";

const AdminPage = () => {
    const {data: questions, refetch, error, isLoading} = questionsAPI.useFetchAllQuestionsQuery()

    console.log('Questions:', questions)

    return (
        <div>
            <Container>
                <Typography variant='h4'> Admin page</Typography>
                <Stack spacing={2}>
                    {
                        questions && questions.map(question => {
                            if (question.type === IQuestionType.TEXT_QUESTION)
                                return <TextField id={String(question.id)}
                                                  label={question.value}
                                                  variant="outlined"
                                />
                            if (question.type === IQuestionType.BOOL_QUESTION)
                                return <FormControlLabel
                                    control={<Checkbox defaultChecked/>}
                                    label={question.value}
                                />

                            if (question.type === IQuestionType.SELECT_QUESTION) {
                                return <FormControl fullWidth>
                                    <InputLabel id="demo-simple-select-label">{question.value}</InputLabel>
                                    <Select
                                        labelId="demo-simple-select-label"
                                        id="demo-simple-select"

                                        value={question?.values?.[0]}
                                        label={question.value}
                                        // onChange={handleChange}
                                    >
                                        {
                                            question.values?.map(pv => <MenuItem value={pv}>{pv}</MenuItem>)
                                        }
                                    </Select>
                                </FormControl>;
                            }
                        })
                    }
                </Stack>
            </Container>
        </div>
    );
};

export default AdminPage;