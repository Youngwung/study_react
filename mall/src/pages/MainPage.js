import React from 'react'
import { Link } from 'react-router-dom'
import BasicLayout from '../layouts/BasicLayout'

export default function MainPage(props) {
	return (
		<BasicLayout>
			<div className='text-3xl'>
				<div>
					<Link to={'/about'}>About</Link>
				</div>
			
				<div>MainPage</div>
			</div>
		</BasicLayout>
	)
}
