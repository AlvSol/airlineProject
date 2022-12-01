import './UserPage.css'

import React , {useState} from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import TextField from '@mui/material/TextField';
import Switch from '@mui/material/Switch';
import PropTypes from 'prop-types';
import { alpha } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import TableSortLabel from '@mui/material/TableSortLabel';
import Paper from '@mui/material/Paper';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import DeleteIcon from '@mui/icons-material/Delete';
import FilterListIcon from '@mui/icons-material/FilterList';
import { visuallyHidden } from '@mui/utils';
import InputLabel from '@mui/material/InputLabel';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';
import Collapse from '@mui/material/Collapse';
import CloseIcon from '@mui/icons-material/Close';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

//____________________________________________________________________________________//

function UserPage(props) {

    const nationalities =[
        'Spanish',
        'English',
        'French',
        'Italian'
    ]
  
    const label = { inputProps: { 'aria-label': 'Switch demo' } };

    const [age, setAge] = useState('');
    const ageChange = (event) => {
        setAge(event.target.value);
    };
    const [nationality, setNationality] = useState('');
    const nationalityChange = (event) => {
        setNationality(event.target.value);
    };

    const [lugageWarning, setlugageWarning] = React.useState(false);
    
    function getFinalPrice(flyprice){
        let finalprice;
        finalprice = (lugageWarning? flyprice*1.2 : flyprice);
        for(let i=0; i < extraPassengers.length;++i){

            if(extraPassengers[i].age==1){
                finalprice += flyprice*.5;
            }
            else if(extraPassengers[i].age==2){
                finalprice += flyprice;
            }
        }
        return finalprice;
    }

    const [extraPassengers, setExtraPassengers] = useState( [
        {
            id:1,
            age:2
        }
    ]);

    const passengerAgeChange = (id, e) => {
        const auxPassengers = [...extraPassengers];
        auxPassengers[id-1].age = e.target.value;
        setExtraPassengers([...auxPassengers]);
        console.log(extraPassengers);
    };

    const AddPassenger=()=>{
        const auxPassengers =[...extraPassengers];
        auxPassengers.push({id: extraPassengers.length+1, age:2});
        setExtraPassengers([...auxPassengers]);
        console.log(extraPassengers);
    }
    const RemovePassenger=()=>{
        const auxPassengers = [...extraPassengers];
        auxPassengers.pop();
        setExtraPassengers([...auxPassengers]);
        console.log(extraPassengers);
    }


    const [open, setOpen] = React.useState(false);
    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
    };


    const [nameText,        setNameText]        = React.useState("");
    const [surnameText,     setSurnameText]     = React.useState("");
    const [idText,          setIDText]          = React.useState("");
    const [errorMessage,    setErrorMessage]    = React.useState("");
    const [buyMessage,      setBuyMessage]      = React.useState("buymessage");

    // Set errorMessage only if text is equal or bigger than MAX_LENGTH
    React.useEffect(() => {
        if (nameText.length <1) setErrorMessage("The input has exceeded the maximum number of characters");
    }, [nameText]);
    React.useEffect(() => {
        if (surnameText.length <1) setErrorMessage("The input has exceeded the maximum number of characters");
    }, [surnameText]);
    React.useEffect(() => {
        if (idText.length <1) setErrorMessage("The input has exceeded the maximum number of characters");
    }, [idText]);

    React.useEffect(()=>{
        if(nameText && surnameText && idText && age && nationality)
           setBuyMessage("You have successfully bought your tickets!");
        else
            setBuyMessage("Complete all captions to buy the tickets");
    }, [nameText,surnameText, idText, age, nationality])

    // Set empty erroMessage only if text is less than MAX_LENGTH
    // and errorMessage is not empty.
    // avoids setting empty errorMessage if the errorMessage is already empty
    React.useEffect(() => { if (nameText.length >1 && errorMessage) setErrorMessage(""); }, [nameText, errorMessage]);
    React.useEffect(() => { if (surnameText.length >1 && errorMessage) setErrorMessage(""); }, [surnameText, errorMessage]);
    React.useEffect(() => { if (idText.length >1 && errorMessage) setErrorMessage(""); }, [idText, errorMessage]);

    
  return (
    <>
        <header>
            <AppBar position="static">
            <Container maxWidth="xl">
                <Toolbar disableGutters>
                    <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
                        <Typography
                            variant="h6"
                            noWrap
                            component="a"
                            href="/"
                            sx=
                            {{
                                mr: 2,
                                display: { xs: 'none', md: 'flex' },
                                fontFamily: 'monospace',
                                fontWeight: 700,
                                letterSpacing: '.3rem',
                                color: 'inherit',
                                textDecoration: 'none',
                            }}>
                                SOLERA AIRLINES
                        </Typography>
                    </Toolbar>
                </Container>
            </AppBar>
        </header>
        <body className='userBody'>
            <div className='passengerForm'>
                <div className='passengerData'> 
                <h2>Passenger info</h2>
                    <Card variant="outlined">
                        <React.Fragment>
                            <CardContent>

                                <TextField required id="standard-basic" label="Name" variant="standard" 
                                helperText="Please enter your name" className='textInput' error={nameText.length <1}
                                onChange={(e) => setNameText(e.target.value)} value={nameText}/>
                                <TextField required id="standard-basic" label="Surname" variant="standard" 
                                helperText="Please enter your surname" className='textInput'error={surnameText.length <1}
                                onChange={(e) => setSurnameText(e.target.value)} value={surnameText}/>

                                <Box sx={{ minWidth: 120 }}>
                                    <FormControl fullWidth>
                                        <InputLabel id="demo-simple-select-label">Nationality</InputLabel>
                                        <Select
                                            labelId="demo-simple-select-label"
                                            id="demo-simple-select"
                                            error ={nationality==''}
                                            value={nationality}
                                            label="nationality"
                                            onChange={nationalityChange}
                                        >
                                            {nationalities.map((nationality)=>(
                                                <MenuItem value={1}> {nationality} </MenuItem>
                                            ))}
                                        </Select>
                                    </FormControl>
                                </Box>  

                                <TextField required id="standard-basic" label="Identification" variant="standard"
                                    helperText="Please enter your NIF" className='textInput'error={idText.length <1}
                                    onChange={(e) => setIDText(e.target.value)} value={idText}/>

                                <Box sx={{ minWidth: 120 }}>
                                    <FormControl fullWidth>
                                        <InputLabel id="demo-simple-select-label">Age</InputLabel>
                                        <Select
                                            labelId="demo-simple-select-label"
                                            id="demo-simple-select"
                                            error={age==''}
                                            value={age}
                                            label="age"
                                            onChange={ageChange}
                                        >
                                            <MenuItem value={1}> {'<2 years'} </MenuItem>
                                            <MenuItem value={2}> {'2-9 years'} </MenuItem>
                                            <MenuItem value={3}>{'>9 years'}</MenuItem>
                                        </Select>
                                    </FormControl>
                                </Box>

                            </CardContent>
                            <CardActions>
                                <div className='hasLugage'>
                                    <p>Has lugage?</p>
                                    <Switch {...label} onClick={()=>{setlugageWarning(!lugageWarning)}} />
                                    <Collapse in={lugageWarning}>
                                        <Alert severity="warning">This will increase the final price </Alert>
                                    </Collapse>
                                </div>
                            </CardActions>
                        </React.Fragment>
                    </Card>
                </div>
            </div>

            <div className='extraPassengers'>
                <TableContainer component={Paper}>
                    <Table aria-label="simple table" sx={{height: 23}}>
                        <TableBody>
                            {extraPassengers.map((row) => (
                                <TableRow>
                                    <TableCell component="th" scope="row"> {row.id} </TableCell>
                                    <TableCell>
                                        <FormControl fullWidth>
                                            <InputLabel id="demo-simple-select-label">Age</InputLabel>
                                                <Select
                                                    labelId="demo-simple-select-label"
                                                    id="demo-simple-select"
                                                    value={row.age}
                                                    label="age"
                                                    onChange={(e)=>passengerAgeChange(row.id, e)}
                                                >
                                                    <MenuItem value={1}> {'<2 years'}   </MenuItem>
                                                    <MenuItem value={2}> {'2-9 years'}  </MenuItem>
                                                    <MenuItem value={3}> {'>9 years'}   </MenuItem>
                                                </Select>
                                        </FormControl>
                                    </TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
                <div className='passengerButtons'>
                    <Button variant="contained" onClick = {AddPassenger}>   Add Passenger   </Button>
                    <Button variant="contained" onClick = {RemovePassenger}>Remove Passenger</Button>                
                </div>
                <div className='priceText'>
                    <h2>Total price: </h2><h2>{getFinalPrice(20)}</h2>
                    <Button variant="contained" onClick={handleClickOpen}> Buy tickets</Button>   
                </div>
            </div>
            <div className='successBought'>
                <Dialog
                    open={open}
                    onClose={handleClose}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                > 
                    <DialogTitle id="alert-dialog-title">
                        {buyMessage}
                    </DialogTitle>
                    <DialogActions>
                        <Button onClick={handleClose}>Continue</Button>
                    </DialogActions>
                </Dialog>
                {console.log()}
            </div>
        </body>        
    </>
  );
}


  
export default UserPage;