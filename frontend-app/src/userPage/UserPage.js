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
  
    // const handleButton=(e)=>{
    //     console.log("http://localhost:8080/flights/api/travel/" + origin + "/" + destiny);
    //     e.preventDefault();
    //     fetch("http://localhost:8080/flights/api/travel/" + origin + "/" + destiny, {
    //         method:"GET"
    //     }).then(()=>{
    //         console.log("buscado")
    //     });
    // }

    

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

                                <TextField id="standard-basic" label="Name" variant="standard" 
                                helperText="Please enter your name" className='textInput'/>
                                <TextField id="standard-basic" label="Surname" variant="standard" 
                                helperText="Please enter your surname" className='textInput'/>

                                <Box sx={{ minWidth: 120 }}>
                                    <FormControl fullWidth>
                                        <InputLabel id="demo-simple-select-label">Nationality</InputLabel>
                                        <Select
                                            labelId="demo-simple-select-label"
                                            id="demo-simple-select"
                                            value={nationality}
                                            label="nationality"
                                            onChange={nationalityChange}
                                        >
                                            {nationalities.map((nationality)=>(
                                                <MenuItem value={0}> {nationality} </MenuItem>
                                            ))}
                                        </Select>
                                    </FormControl>
                                </Box>  

                                <TextField id="standard-basic" label="Identification" variant="standard"
                                    helperText="Please enter your NIF" className='textInput'
                                />

                                <Box sx={{ minWidth: 120 }}>
                                    <FormControl fullWidth>
                                        <InputLabel id="demo-simple-select-label">Age</InputLabel>
                                        <Select
                                            labelId="demo-simple-select-label"
                                            id="demo-simple-select"
                                            value={age}
                                            label="age"
                                            onChange={ageChange}
                                        >
                                            <MenuItem value={0}> {'<2 years'} </MenuItem>
                                            <MenuItem value={1}> {'2-9 years'} </MenuItem>
                                            <MenuItem value={2}>{'>9 years'}</MenuItem>
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
                                                    <MenuItem value={0}> {'<2 years'}   </MenuItem>
                                                    <MenuItem value={1}> {'2-9 years'}  </MenuItem>
                                                    <MenuItem value={2}> {'>9 years'}   </MenuItem>
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
                    <Button variant="contained" onClick = {RemovePassenger}>Buy tickets</Button>   
                </div>
            </div>
        </body>        
    </>
  );
}


  
export default UserPage;