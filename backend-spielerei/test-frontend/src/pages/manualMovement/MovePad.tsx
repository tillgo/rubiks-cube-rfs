import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import {IconButton} from "@mui/material";
import {useCallback} from "react";
import {SendMessage} from "react-use-websocket";

const MovePad = (props: {sendMessage: SendMessage}) => {
    const {sendMessage} = props

    const handleClickSendMessage = useCallback(() => {
        console.log("Test")
        sendMessage('{moveType: "ROBO_ARM", moveDirection: "FRONT"}')
    }, []);


        return(
            <IconButton onClick={handleClickSendMessage}>
                    <KeyboardArrowUpIcon/>
            </IconButton>
        )
}

export default MovePad